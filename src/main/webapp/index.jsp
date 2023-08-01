<script type="text/javascript">
	console.log("Test Data changed");
	var fallbackToStore = function() {
		console.log("fallback to store started");
		window.location.replace('market://details?id=com.eisedo.eisedo');
		console.log("fallback to store done");
	};
	var openApp = function() {
		console.log("open app started");
		window.location.replace('com.eisedo.eisedo://');
		console.log("openApp done");
	};
	var triggerAppOpen = function() {
		console.log("trieggeredopenApp");
		openApp();
		setTimeout(fallbackToStore, 250);
		console.log("triggered openApp");
	};

	window.onload = triggerAppOpen;

	//	var name = new triggerAppOpen();

	//	triggerAppOpen();
</script>
<html>
<body>
	<h2>Hello World!</h2>
</body>
</html>
