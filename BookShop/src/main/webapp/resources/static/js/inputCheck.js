/** js  ->  jQuery   ->     React, Vue, Agular      ->      바닐라 JS
 * 
 * jQuery는 코드길이가 짧아짐
 *      DOM에서 돌아감.
 * 
 * R.V.A
 *      SPA?
 *      웹 앱에 많이 사용됨.
 *          앱 생태계는 돈이 안됨.
 * 
 * 바닐라JS
 *      코드 길이가 길지만 툴이 많이 늘어남.
 */

//다른곳에서도 입력 확인가능
//입력 확인
window.addEventListener("load", () => {
    //Id로 요소 선택
    //해당 요소가 클릭됬을 때 이벤트 처리
    document.getElementById("submit").addEventListener("click", e => {
        const [signup_form] = document.getElementsByTagName("signup_form");
        console.log(signup_form);
        console.log(signup_form.id);
        //[]를 붙여서 배열로 받음.s
        //배열로 받으면 length, forEach, map 등 배열 메서드를 사용할 수 있음.
        //배열로 받지 않으면 HTMLCollection으로 받아서 배열 메서드를 사용할 수 없음.
        //HTMLCollection은 배열이 아님.

        //태그안의 name 속성으로 요소 선택
        //value 속성으로 값 가져오기

            if(signup_form.id.value === "") {
                alert("이름을 입력하세요.");
                signup_form.id.focus();
                return;
            }

            if(signup_form.password.value === "") {
                alert("비밀번호를 입력하세요.");
                signup_form.password.focus();
                return;
            }

            if(signup_form.name.value === "") {
                alert("성명을 입력하세요.");
                signup_form.name.focus();
                return;
            }
            signup_form.submit();
    });
});
