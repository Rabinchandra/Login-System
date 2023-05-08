<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://kit.fontawesome.com/c12e219398.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css" />
    <title>Sign in & Sign up Form</title>
  </head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup"
        >
        <!-- Login form -->
          <form action="login" class="sign-in-form" id="login">
            <h2 class="title">Sign in</h2>
            <div class="msg" id="login-msg"></div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" name="username" id="login-username" autocomplete="off"/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name="password" id="login-password"/>
            </div>
            <input type="submit" value="Login" class="btn solid" />

            <p class="social-text">Or Sign in with social platforms</p>

            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </div>
          </form>

          <!-- Sign up form -->
          <!-- username, birthday, gender, occupation, address -->
          <form action="signup" class="sign-up-form" id="signup">
            <h2 class="title">Sign up</h2>
            <div class="msg valid" id="signup-msg"></div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" id="signup-username"/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" id="signup-password"/>
            </div>
          
            <div class="input-field">
              <i class="fa fa-birthday-cake"></i>
              <input type="date" placeholder="Birthday" placeholder="dd-mm-yyyy" id="signup-birthday" />
            </div>

            <div class="input-field">
              <i class="fas fa-venus-mars"></i>
              <input type="text" placeholder="Gender" id="signup-gender"/>
            </div>

            <div class="input-field">
              <i class="fa fa-graduation-cap"></i>
              <input type="text" placeholder="Occupation" id="signup-occupation"/>
            </div>

            <div class="input-field">
              <i class="fas fa-address-book"></i>
              <input type="text" placeholder="Address" id="signup-address"/>
            </div>

            <input type="submit" class="btn" value="Sign up" />
            
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>New here ?</h3>
            <p>
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis,
              ex ratione. Aliquid!
            </p>
            <button class="btn transparent" id="sign-up-btn">
              Sign up
            </button>
          </div>
          <img src="img/log.svg" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>One of us ?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
              laboriosam ad deleniti.
            </p>
            <button class="btn transparent" id="sign-in-btn">
              Sign in
            </button>
          </div>
          <img src="img/register.svg" class="image" alt="" />
        </div>
      </div>
    </div>

	<script src="main.js"></script> 
  </body>
</html>
