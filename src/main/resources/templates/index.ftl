<#-- @ftlvariable name="records" type="kotlin.collections.List<com.example.Record>" -->
<!DOCTYPE html>
<html lang="ja">
    <head>
        <title>Ktor Sample</title>
    </head>
    <body>
        <h1>Hello World</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>タイトル</th>
                    <th>内容</th>
                </tr>
            </thead>
            <tbody>
                <#list records as record>
                    <tr>
                        <td>${record.title}</td>
                        <td>${record.body}</td>
                    </tr>
                </#list>
            </tbody>
        </table>

        <form action="/submit" method="POST">

            <div>
                <label>
                    タイトル
                    <input type="text" name="title">
                </label>
            </div>
            <div>
                <label>
                    本文
                    <textarea name="body"></textarea>
                </label>
            </div>
            <button type="submit">提出</button>
        </form>
    </body>
</html>
