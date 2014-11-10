appgyver_test
=============

For appgyver, use the appgyver branch

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
