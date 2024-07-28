// src/api.js

import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // 서버 주소
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
    window.location.href = '/';
  }
  return Promise.reject(error);
});

export default api;