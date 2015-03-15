/**
 * 验证账号输入是否为空
 */
function checkUser() {
	var phone = document.getElementById('phone');
	var pwd = document.getElementById('password');

	if (phone.value == "" || phone.value == null) {
		alert("请输入账号!");
		phone.focus();
		return false;
	} else {
		if (pwd.value == "" || pwd.value == null) {
			alert("请输入密码!");
			pwd.focus();
			return false;
		} else {
			return true;
		}

	}

}

/**
 * 更换验证码
 */
function changecode(){
	var verifyObj = document.getElementById("Verify");
    verifyObj.onclick=function(){
        this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
    };
}

window.onload=function(){
    var verifyObj = document.getElementById("Verify");
    verifyObj.onclick=function(){
        this.src="SecurityCodeImageAction?timestamp="+new Date().getTime();
    };
}

/**
 * 使用jquery
 */
$(document).ready(function(){
	
});