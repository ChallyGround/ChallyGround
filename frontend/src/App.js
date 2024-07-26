import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './css/App.css';

import Header from './components/Header';
import Sidebar from './components/SideBar';
import Login from './pages/main/Login';
import Main from './pages/main/Main';
import MyPage from './pages/user/MyPage';
import LoginSuccess from './pages/main/LoginSuccess';
import SubmitData from './pages/SubmitData';
import EditUserInfo from './pages/user/EditUserInfo';

function App() {
  return (
    <div>
      <Header />
      <Sidebar />
        <Routes>
          <Route path="/" element={
              <div style={{ marginLeft: '245px' }}>
              <Login />
              </div>
          } />
          <Route path="/home" element={
            <div style={{ marginLeft: '245px' }}>
            <Main />
          </div>
          } />
          <Route path="/submit" element={
              <div style={{ marginLeft: '245px' }}>
              <SubmitData  />
              </div>
          } />
          <Route path="/mypage" element={
              <div style={{  marginLeft: '245px' }}>
              <MyPage />
              </div>
          } />
          <Route path="/EditUserInfo" element={
              <div style={{  marginLeft: '245px' }}>
              <EditUserInfo />
              </div>
          } />
          <Route path="/login-success" element={
            <LoginSuccess />
          } />
        </Routes>
    </div>
  );
}

export default App;
