module.export = {
  Map: {
    getMap: function() {
      setTimeout(function(){
        cordova.exec(null, null, "GoogleMaps", "exec", []);
      }, 3000);
    }
  }
};
cordova.addConstructor(function() {
  if (!window.Cordova) {
    window.Cordova = cordova;
  };
  window.plugin = window.plugin || {};
  window.plugin.google = window.plugin.google || {};
  window.plugin.google.maps = window.plugin.google.maps || module.exports;
});
