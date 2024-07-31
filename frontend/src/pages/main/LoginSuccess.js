// src/pages/main/LoginSuccess.js

import React, { useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import api from '../../api/axiosApi';

const LoginSuccess = () => {
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    const queryParams = new URLSearchParams(location.search);
    const token = queryParams.get('token');

    if (token) {
      localStorage.setItem('jwt', token);
      navigate('/mypage');
    } else {
      navigate('/');
    }
  }, [location, navigate]);

  return (
    <div>
      <h1>Processing login...</h1>
    </div>
  );
};

export default LoginSuccess;
