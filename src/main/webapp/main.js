const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");
// Login
const loginForm = document.querySelector("#login");
const username = document.querySelector("#login-username");
const password = document.querySelector("#login-password");

// sign up
const signUpForm = document.querySelector("#signup");
const signup_username = document.querySelector("#signup-username");
const signup_password = document.querySelector("#signup-password");
const signup_birthday = document.querySelector("#signup-birthday");
const signup_gender = document.querySelector("#signup-gender");
const signup_occupation = document.querySelector("#signup-occupation");
const signup_address = document.querySelector("#signup-address");

// msg
const loginMsgDiv = document.querySelector("#login-msg");
const signupMsgDiv = document.querySelector("#signup-msg");

// Login user
function loginUser(username, password) {
		fetch('/LoginProject/login', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({ username: username, password: password })
		})
		.then(res => res.json())
		.then(data => {
			if(data.hasError) {
				
				loginMsgDiv.innerText = data.error + " :(";
				loginMsgDiv.classList.add('invalid');
				
				setTimeout(() => {
					loginMsgDiv.innerText = '';
				}, 3000);
			}
			
			else {
				window.location.href = "/LoginProject/user_profile.jsp";
			}
		});
}

function signUp(username, password, birthday, gender, occupation, address) {
		fetch('/LoginProject/signup', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({ username, password, birthday, gender, occupation, address })
		})
		.then(res => res.json())
		.then(data => {
			if(data.hasError) {
				
				signupMsgDiv.innerText = data.error + " :(";
				signupMsgDiv.classList.replace('valid','invalid');
				
				setTimeout(() => {
					signupMsgDiv.innerText = '';
				}, 3000);
			}
			
			else {
				signupMsgDiv.innerText = " Successfully created :)";
				signupMsgDiv.classList.replace('invalid','valid');
				
				setTimeout(() => {
					signupMsgDiv.innerText = '';
				}, 3000);
			}
		});
}


// Add Events
sign_up_btn.addEventListener("click", () => {
	container.classList.add("sign-up-mode");
});
	
sign_in_btn.addEventListener("click", () => {
	container.classList.remove("sign-up-mode");
});

loginForm.addEventListener("submit", (e) => {
	e.preventDefault();
	
	loginUser(username.value, password.value);
});

signUpForm.addEventListener("submit", (e) => {
	e.preventDefault();
	
	signUp(signup_username.value, signup_password.value, signup_birthday.value, signup_gender.value, signup_occupation.value, signup_address.value);
});

