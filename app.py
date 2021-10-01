from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient
import time

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/post', methods=['POST'])
def save_post():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']

    doc = {
        'idx': db.posting.count() + 1,
        'title': title_receive,
        'content': content_receive,
        'reg_date': time.strftime('%Y-%m-%d', time.localtime(time.time())),
    }

    db.posting.insert_one(doc)
    return {"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.posting.find({}, {'_id': False}))
    return jsonify({'post_list': posts})

@app.route('/post/delete', methods=['DELETE'])
def delete_post():
    idx_receive = request.form['idx_give']
    db.posting.delete_one({'idx': idx_receive})
    return jsonify({'msg': '삭제 완료'})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
