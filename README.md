appgyver_test
=============

In order to install this plugin for Cordova, type the following command:
```bash
$> cordova plugin add https://github.com/wf9a5m75/appgyver_test --variable API_KEY_FOR_ANDROID=...
```

For AppGyver, use the appgyver branch.
![](https://googledrive.com/host/0B1ECfqTCcLE8VDI3cVU1NDN0c00/Screen Shot 2014-11-10 at 3.14.01 PM.png)



###Example Code

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <script type="text/javascript" src="cordova.js"></script>
    <script type="text/javascript">
    document.addEventListener("deviceready", function() {
      var button = document.getElementById("button");
      button.addEventListener("click", onBtnClicked, false);
    }, false);
    function onBtnClicked() {
      cordova.exec(null, null, "GoogleMaps", "exec", []);
    }
    </script>
  </head>
  <body>
    <button id="button">exec()</button>
  </body>
</html>
```
