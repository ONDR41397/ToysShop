ToysShopショッピングサイト
システムの概要
職業訓練にてSpringBootを使用して、おもちゃ専門のショッピングサイトを作成しました。
管理者は商品の登録、編集、削除が行え、ユーザーは商品の閲覧、購入が行えます。

機能一覧
ログイン認証機能
商品の追加機能
商品の編集機能
商品の削除機能
商品一覧表示
ページネーション

URL一覧
URL	内容
/admin　管理者用ログイン画面
/admin/itemList 管理者用商品一覧画面
/admin/AddItem　商品登録画面
/admin/EditItem　商品編集画面
/　ユーザー用ログイン画面
/itemList　ユーザー用商品一覧画面
/detail　商品詳細画面
/cart　カート画面
/purchaseItem 購入完了画面

その他
データベースの作成、及び初期データを投入するためのSQLは「src/main/resources/sql」内に格納されています。
