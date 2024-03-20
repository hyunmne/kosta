<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address Search API</title>
</head>
<body>
</body>
<div id="map1" style="width:250px;height:250px;margin-top:10px;display:none;"></div>
<div id="map2" style="width:250px;height:250px;margin-top:10px;display:none;"></div>
<div id="map3" style="width:250px;height:250px;margin-top:10px;display:none;"></div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=132351b1a2d2c8dce115b1dede467ee4&libraries=services"></script>
<script>
var mapContainer1 = document.getElementById('map1'); // 지도를 표시할 div 
var mapContainer2 = document.getElementById('map2'); 
var mapContainer3 = document.getElementById('map3'); 
	
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

function addressSearch(address, mapContainer, title) {
	mapContainer.style.display='block';
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(address, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	    	 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	    	 var mapOption = {
	    	            center: coords, 
	    	            level: 3 
	    	        }; 
	    	var map = new kakao.maps.Map(mapContainer, mapOption)
	    	 
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: `<div style="width:150px;text-align:center;padding:6px 0;">\${title}</div>`
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
}

var locs = ${locs};
var maps = [mapContainer1, mapContainer2, mapContainer3];

locs.forEach(function(loc, index) {
	addressSearch(loc.address, maps[index], loc.title);
})
</script>
</html>


