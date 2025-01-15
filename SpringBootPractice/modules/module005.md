# 5. APIの実装
## 5.1. 下記のAPIを全て実装してください
### 5.1.1. GET /examinations
#### 概要
全てのExaminationを取得するAPI
#### Response

```json
[
  {
    "id": 1,
    "name": "Math",
    "description": "Math examination",
    "date": "2021-01-01",
    "fullScore": 10,
    "questionNum": 3
  },
  {
    "id": 2,
    "name": "English",
    "description": "English examination",
    "date": "2021-01-02",
    "fullScore": 10,
    "questionNum": 3
  }
]
```

### 5.1.2. POST /examinations/result
#### 概要
Examinationの結果を登録するAPI

#### Request
```json
{
  "examinationId": 1,
  "userId": 1,
  "answers": [
    {
        "questionId": 1,
        "answer": "A"
        },
        {
        "questionId": 2,
        "answer": "B"
        },
        {
        "questionId": 3,
        "answer": "C"
    }
  ]
}
```

#### Response
```json
{
  "score": 10
}
```
#### Program Flow
1. `examinationId`に対応するQuestionのリストを取得する
2. `answers`の`questionId`に対応するQuestionの正解と比較する
3. 各Questionの配点から、得点を計算する
4. 得点をResponseとして返却する

### 5.1.3. PUT /examinations/{examinationId}/statistic
#### 概要
Examinationの統計値を計算して更新するAPI

#### Request
```json
{
  "examinationId": 1
}
```

#### Response
```json
{
  "result": "success"
}
```

#### Program Flow
1. `examinationId`に対応するexaminationResultのリストを取得する
2. リストから、平均値・最高値・最低値を計算する
3. `examinationId`に対応するExaminationStatisticを取得する
4. ExaminationStatisticがない場合、計算結果からExaminationStatisticを新規作成する。ある場合、計算結果でExaminationStatisticを更新する
5. 新しいExaminationStatisticを保存する
6. Responseとして`result: success`を返却する

### 5.1.4. GET /examinations/statistics
#### 概要
各Examinationsの統計値を取得するAPI

#### Response
```json
[
  {
    "examinationId": 1,
    "average": 8.5,
    "max": 10,
    "min": 7
  },
  {
    "examinationId": 2,
    "average": 9.0,
    "max": 10,
    "min": 8
  }
]
```