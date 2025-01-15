# 4.APIを理解する
## 4.1. Role APIの実装
``課題`` 
1. UserControllerを参考に、下記のAPIを実装してください。
- `GET /roles` : 全てのRoleを取得するAPI
2. `UserControllerTest`を参考に、RoleControllerのテストを実装してください。
3. 実装ができたら下記のスクリプトでテストを実行してください。
```bash
./gradlew test --tests com.training.SpringBootPractice.e2e.RoleControllerTest
```

## 4.2. User APIの実装
``課題`` 
1. RoleControllerを参考に、下記の機能を行えるAPIを実装してください。
- 対象の社員情報を編集するAPI
- 対象の社員を削除するAPI

実装の際には、下記のことを意識してみてください。
```
- 適切なHTTPメソッドを選択する（GET, POST, PUT, DELETE）
- PathVariable, RequestParam, RequestBodyの使い分け
```

2. `UserControllerTest`に今回作成したAPIのテストを追加してください。
3. 実装ができたら下記のスクリプトでテストを実行してください。
```bash
./gradlew test --tests com.training.SpringBootPractice.e2e.UserControllerTest
```

## 4.3. 複雑な構造のデータを取得する
``課題`` 
1. すでに実装されている`GET /users`のAPIを修正して、下記の値をResponseとして返却するようにしてください。

```
[
    {
      "id": 1,
      "name": "John",
      "roleName": "admin"
    },
    {
      "id": 2,
      "name": "Smith",
      "roleName": "owner"
    }
]
```

```
参考：
- https://medium.com/@ksaquib/leveraging-the-data-transfer-object-dto-pattern-in-spring-boot-enhancing-data-transfer-efficiency-5bd2dc488d0d
- https://zenn.dev/teru_whisky/books/e53e912b522983/viewer/page6
```

2. `UserControllerTest.getUserList`を修正して、各`User`のid, name, roleNameが正しく取得できているかを判定できるテストにしてください。
3. 実装ができたら下記のスクリプトでテストを実行してください。
```bash
./gradlew test --tests com.training.SpringBootPractice.e2e.UserControllerTest
```
