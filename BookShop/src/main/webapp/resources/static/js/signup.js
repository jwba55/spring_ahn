    //ajax 통신
    //async javascript and xml
    //비동기 통신
    //서버에 요청을 보내고 응답을 받는 동안 다른 작업을 할 수 있음.
    //서버에 요청을 보내고 응답을 받으면 콜백 함수가 호출됨.
	//ajax의 핵심은 필요한 데이터만 주고 받을 수 있다는 것이다.

let checkIdFlag = false;
let checkId = '';

function pwdCofirmMouseDown(_that){
	_that.closest(".pwd").querySelector("input").setAttribute("type","text");
}

function pwdCofirmMouseUp(_that){
	_that.closest(".pwd").querySelector("input").setAttribute("type","password");
}

window.addEventListener("load", () => {
    //이벤트 핸들러는 언제 걸리나?
    //사용자가 버튼을 클릭했을 때
    // document.querySelectorAll(".pwd").forEach(users=> {
    //     const input = users.querySelector("input[type=`password`]");
    //     const button = users.querySelector(".view");

    //     button.addEventListener("mousedown", () => {
    //         input.setAttribute("type", "text");
    //     });
    //     button.addEventListener("mouseup", () => {
    //         input.setAttribute("type", "password");
    //     });

    //     button.addEventListener("mouseout", () => {
    //         input.setAttribute("type", "password");
    //     });
    // });



    //아이디 중복확인 후 바뀔 경우 다시 중복확인
    document.querySelector("input[name='id']").addEventListener("change", e => {
        checkIdFlag = false;
    });

    //아이디-[fetch] 중복확인
    document.getElementById("checkIdFetch").addEventListener("click", e => {
        const button = e.target;
        const id = document.querySelector("input[name='id']").value;

        button.setAttribute("disabled", true);

        fetch("checkId/${id}", {
            method: "GET",
        }).then(resp => {
            button.removeAttribute("disabled");

            if (resp.ok) {
                return resp.text();
            } else {
                throw new Error("[fetch] 아이디 중복검사를 할 수 없습니다");
            }
        }).then(result => {
            if (result == "OK") {
                alert("[fetch] 사용가능한 아이디 입니다");
                checkId = true;
            } else {
                alert("[fetch] 이미 다른 사용자가 사용하는 아이디 입니다");
            }
        }).catch(e => alert(e));
    });

    document.getElementById("checkId").addEventListener("click", e => {

        //form 태그를 거치지 않고 값을 가져오는 방법
        //id 속성으로 요소 선택
        //dom을 읽으면서 input 태그의 name 속성이 id인 요소를 선택
        //    단점: 오류가 발생할 수 있음.
        const id = document.querySelector("input[name='id']").value;

        if(id === null || id === undefined || id === ""){
			alert("아이디를 입력하세요");
			return;
		}

        //서버와 통신할 때 사용하는 객체
        const xhr = new XMLHttpRequest();

        xhr.open("get", `/checkId/${id}`, false);    //async가 true면비동기 통신

        xhr.send();
        if(xhr.status === 200 ){
            if(xhr.responseText === "OK") {
                alert("[동기]사용할 수 있는 아이디입니다.");
                document.getElementById("password").focus();
                checkId = true;
            } else {
                alert("[동기]이미 등록된 아이디입니다.");
                document.getElementById("id").focus();
            }
        } else {
            alert("[동기]서버와 통신할 수 없습니다.");
        }
    });

    //아이디-[비동기] 중복확인
    document.getElementById("checkIdAsync").addEventListener("click", e => {
        const button = e.target;
        const id = document.querySelector("input[name='id']").value;

        button.setAttribute("disabled", true);

        const xhr = new XMLHttpRequest();

        xhr.open("GET", `checkId/${id}`, true);

        xhr.onreadystatechange = () => {
            if (xhr.readyState == xhr.DONE) {
                button.removeAttribute("disabled");

                if (xhr.status == 200) {
                    if (xhr.responseText == "OK") {
                        alert("[비동기] 사용가능한 아이디 입니다");
                        checkId = true;
                    } else {
                        alert("[비동기] 이미 다른 사용자가 사용하는 아이디 입니다");
                    }
                } else {
                    alert("[비동기] 아이디 중복검사를 할 수 없습니다");
                }
            }
        }
        
        xhr.send();
    });

});