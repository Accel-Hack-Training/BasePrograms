# 3. JPAを使ってみる
## 3.1. Mockを理解する
``課題``
1. Mockとは何かをまずは調べてみてください。
1. Mockが何かを理解したら、`UserServiceTest`の不足しているテストを実装してください。
1. 実装ができたら下記のスクリプトでテストを実行してください。
```bash
./gradlew test --tests com.training.SpringBootPractice.service.UserServiceTest
```
４全てのテストが成功したら、次の課題に進んでください。

## 3.2. RoleServiceの実装
``課題１`` データベースからRoleを取得する`RoleService`を実装してください。<br/>
実装の必要があるクラス一覧
- `com/training/SpringBootPractice/model/Role.java`
- `com/training/SpringBootPractice/service/RoleService.java`
- `com/training/SpringBootPractice/service/impl/RoleServiceImpl.java`
- `com/training/SpringBootPractice/repository/RoleRepository.java`

``課題２`` `RoleService`の実装が完了したら、RoleServiceのテストを実装してください。<br/>
実装の必要があるクラス一覧
- `test/../com/training/SpringBootPractice/service/RoleServiceTest.java`
    
``課題３`` 全てのテストが成功したら、次のmoduleに進んでください。
