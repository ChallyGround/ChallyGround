import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './css/App.css';

import Header from './components/Header';
import Sidebar from './components/SideBar';
import Login from './pages/main/Login';
import Main from './pages/main/Main';
import MyPage from './pages/user/MyPage';
import LoginSuccess from './pages/main/LoginSuccess';
import SubmitData from './pages/SubmitData';

function App() {
  return (
    <div>
      <Header />
      <Sidebar />
        <Routes>
          <Route path="/" element={
              <div style={{ display: 'flex' }}>
              <Header />
              <Sidebar />
              <Login />
              </div>
          } />
          <Route path="/home" element={
            <div style={{ display: 'flex' }}>
            <Header />
            <Sidebar />
            <Main />
          </div>
          } />
          <Route path="/submit" element={
              <div style={{ display: 'flex' }}>
              <Header />
              <Sidebar />
              <SubmitData  />
              </div>
          } />
          <Route path="/mypage" element={
              <div style={{ display: 'flex' }}>
              <Header />
              <Sidebar />
              <MyPage />
              </div>
          } />
          <Route path="/login-success" element={<LoginSuccess />} />
        </Routes>
    </div>
  );
}

export default App;
