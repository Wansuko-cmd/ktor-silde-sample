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
    </body>
</html>
