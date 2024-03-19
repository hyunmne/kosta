<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kakao Map</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=132351b1a2d2c8dce115b1dede467ee4&libraries=services"></script>
</head>
<body>
<button id="currentPos">현위치 지도 보기</button>
<div id="map" style="width:500px;height:400px;"></div>
<div id="currentAddr"></div>
<script>
	var container = document.getElementById('map');
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 버튼 클릭 시 현재 위치의 위도와 경도를 얻어와 지도에 반영
	var btn = document.getElementById('currentPos');
	btn.onclick = function(){
		if(!navigator.geolocation) {
			alert("위치 정보가 지원되지 않습니다.")
			return;
		}
		navigator.geolocation.getCurrentPosition(success);
	}
	
	// 현재 위치와 조회 시간을 파라미터로 가지고 호출되는 함수
	function success({coords, timestamp}) {
		const latitude = coords.latitude; // 위도
		const longitude = coords.longitude // 경도
		
		console.log(`위도:\${latitude}, 경도:\${longitude}, 위치 반환 시간:\${timestamp}`);
		var coord = new kakao.maps.LatLng(latitude, longitude);
		
		new kakao.maps.Map(container, {center:coord, level:3});
		
		// 위도와 경도로 주소를 얻어오기
		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback)
	}
	
	// 주소 값을 파라미터로 가지고 호출되는 함수
	function callback(result, status) {
		if(status===kakao.maps.services.Status.OK) {
			var currentAddr = document.getElementById('currentAddr');
			console.log(result[0].address)
			currentAddr.innerText = result[0].address.address_name;
		}
	}
	
	// 처음 실행 시 지도에 카카오 센터 위치 지정
	var options = {
		center : new kakao.maps.LatLng(33.450701, 126.570667),
		level : 3
	};

	new kakao.maps.Map(container, options);
	
	
</script>
</body>
</html>