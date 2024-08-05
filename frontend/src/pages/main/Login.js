import React from 'react';

const hostUrl = process.env.REACT_APP_API_URL;

const Login = () => {
  const googleLogin = () => {
    window.location.href = hostUrl + '/chally/oauth2/authorization/google';
  };

  return (
    <div>
      <h1>Login</h1>
      <button onClick={googleLogin}>Login with Google</button>
    </div>
  );
};

export default Login;