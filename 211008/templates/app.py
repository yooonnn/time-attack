from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/post', methods=['POST'])
def save_post():
    title = request.form.get('title')
    content = request.form.get('content')
    post_count = db.post.count_documents()
    if post_count == 0:
        max_value = 1
    else:
        max_value = db.post.find_one(sort=[("idx", -1)])['idx'] + 1

    post = {
        'idx': max_value,
        'title': title,
        'content': content,
        'reg_date': datetime.now(),
        'views': 0
    }
    db.post.insert_one(post)
    return {"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.post.find({}, {'_id': False}).sort([("reg_date", -1)]))
    for a in posts:
        a['reg_date'] = a['reg_date'].strftime('%Y.%m.%d %H:%M:%S')

    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.post.delete_one({'idx': int(idx)})
    return {"result": "success"}

@app.route('/post/view', methods=['POST'])
def update_view():
    title_receive = request.form['idx_give']
    print(title_receive)
    target_writer = db.post.find_one({'writer': title_receive})
    current_views = target_writer['views']
    new_views = current_views + 1
    db.post.update_one({'writer': title_receive}, {'$set': {'views': new_views}})
    return jsonify({'msg': '완료'})


# 수정하기
# @app.route('/post/change', methods=['GET'])
# def find_update_post():
#     idx = request.args.get('idx')
#     update_posting = db.post.find_one({'idx': int(idx)}, {'_id': False})
#     update_part = update_posting['title']
#     print(update_part)
#     return jsonify(update_posting)

# @app.route('/post/change', methods=['POST'])
# def update_post():
#     idx = request.args.get('idx')
#     update_posting = db.post.find_one({'idx': int(idx)}, {'_id': False})
#     return jsonify(update_posting)


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)