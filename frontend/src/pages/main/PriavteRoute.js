import React from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children }) => {
    const isAuthenticated = true; // 인증 상태를 확인하는 로직을 여기에 구현

    return isAuthenticated ? children : <Navigate to="/" />;
};

export default PrivateRoute;