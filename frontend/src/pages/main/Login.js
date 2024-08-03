import React from 'react';

const Login = () => {
  const googleLogin = () => {
    window.location.href = 'http://49.174.231.190:8080/chally/oauth2/authorization/google';
  };

  return (
    <div>
      <h1>Login</h1>
      <button onClick={googleLogin}>Login with Google</button>
    </div>
  );
};

export default Login;