/**
 * 
 */

window.addEventListener("load", () => {
    document.getElementById("checkId").addEventListener("click", e => {
        //form 태그를 거치지 않고 값을 가져오는 방법
        //id 속성으로 요소 선택
        //dom을 읽으면서 input 태그의 name 속성이 id인 요소를 선택
        //    단점: 오류가 발생할 수 있음.
        const id = document.querySelector("input[name='id']").value;

        //서버와 통신할 때 사용하는 객체
        const xhr = new XMLHttpRequest();

        xhr.open("get", `/check_Id/${id}`, false);    //async가 true면비동기 통신

        xhr.send();
        if(xhr.status === 200 ){
                    if(xhr.responseText === "OK") {
            alert("사용할 수 있는 아이디입니다.");
            document.getElementById("password").focus();
            return;
            } else {
                alert("이미 등록된 아이디입니다.");
                document.getElementById("id").focus();
                return;
            }
        } else {
            alert("서버와 통신할 수 없습니다.");
            return;
        }

        //ajax 통신
        //async javascript and xml
        //비동기 통신
        //서버에 요청을 보내고 응답을 받는 동안 다른 작업을 할 수 있음.
        //서버에 요청을 보내고 응답을 받으면 콜백 함수가 호출됨.
		//ajax의 핵심은 필요한 데이터만 주고 받을 수 있다는 것이다.
    });
});