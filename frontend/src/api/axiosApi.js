// src/api.js

import axios from 'axios';

const apiUrl = process.env.REACT_APP_API_URL;

const api = axios.create({
  baseURL: apiUrl + '/chally/api', // 서버 주소
});

api.interceptors.request.use((config) => {
  const token = localStorage.getItem('jwt');
  if (token) {
    config.headers.Authorization = `Chally ${token}`;
  }
  return config;
}, error => {
  return Promise.reject(error);
});

api.interceptors.response.use((response) => {
  return response;
}, (error) => {
  if (error.response && error.response.status === 401) {
    // 401 Unauthorized 응답을 받으면 로그인 페이지로 리다이렉트
    window.location.href = '/chlogin';
  }
  return Promise.reject(error);
});

export default api;