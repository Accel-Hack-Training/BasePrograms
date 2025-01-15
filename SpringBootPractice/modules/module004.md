# 4.APIを理解する
## 4.1. Role APIの実装
``課題１`` UserControllerを参考に、下記のAPIを実装してください。
- `GET /roles` : 全てのRoleを取得するAPI

## 4.2. User APIの実装
``課題１`` RoleControllerを参考に、下記の機能を行えるAPIを実装してください。
- 対象の社員情報を編集するAPI
- 対象の社員を削除するAPI

実装の際には、下記のことを意識してみてください。
```
- 適切なHTTPメソッドを選択する（GET, POST, PUT, DELETE）
- PathVariable, RequestParam, RequestBodyの使い分け
```

## 4.3. 複雑な構造のデータを取得する
``課題１`` すでに実装されている`GET /users`のAPIを修正して、下記の値をResponseとして返却するようにしてください。

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
