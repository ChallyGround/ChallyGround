import React, { useState, useEffect } from 'react';
import './App.css';



function App() {
const [points, setPoints] = useState(0);
  const [achievementRate, setAchievementRate] = useState(0);
  const [attendancePopup, setAttendancePopup] = useState(false);
  const [questPopup, setQuestPopup] = useState(false);
  const [currentQuest, setCurrentQuest] = useState('');
  const [lastQuestTime, setLastQuestTime] = useState(null);
  const [userName, setUserName] = useState('Chally');
  const [isEditing, setIsEditing] = useState(false);
  const [newName, setNewName] = useState(userName);
  
  
  
function updateDisplay() {
  document.getElementById('level').textContent = currentLevel;}
  let currentLevel = 1;

  useEffect(() => {
    const timer = setTimeout(() => {
      setAttendancePopup(true);
    }, 2000);

    return () => clearTimeout(timer);
  }, []);

  const handleAttendanceComplete = () => {
    setPoints(points + 2);
    setAchievementRate(((points + 2) / 100) * 100); // 예시 계산식, 필요에 따라 변경
    setAttendancePopup(false);
  };

  const handleQuestClick = () => {
    const now = new Date();
    if (lastQuestTime && (now - lastQuestTime) < 3600000) { // 1시간 = 3600000ms
      alert('퀘스트는 한 시간에 한 번만 수행할 수 있습니다.');
      return;
    }
    setLastQuestTime(now);

    const quests = ['물마시기 퀘스트를 완료하세요.', '스트레칭하기 퀘스트를 완료하세요.'] ;
    const randomQuest = quests[Math.floor(Math.random() * quests.length)];
    setCurrentQuest(randomQuest);
    setQuestPopup(true);
  };

  const handleQuestComplete = () => {
    setPoints(points + 3);
    setQuestPopup(false);
  };

  const handleEditClick = () => {
    setIsEditing(true);
  };

  const handleNameChange = (event) => {
    setNewName(event.target.value);
  };

  const handleNameSave = () => {
    setUserName(newName);
    setIsEditing(false);
  };
  let [챌린지, b] = useState(['2024 지구의 날 챌린지','2024 댄싱 챌린지','2024 러닝 데이 챌린지'])
  let [얻을포인트, c] = useState (['+80','+250','+50'])

  return (
    <div className="app">
      <div className="profile">
        <div className="header">
        <h1>{userName}</h1>
          <button onClick={handleEditClick}>✏️수정하기</button>
        </div>
        <div className="line">
          <button onClick={handleQuestClick}>일일퀘스트</button>
          <span>💰coin: {points}</span>
        </div>
        <div class="level"><h3>LV. <span id="level">1</span></h3> </div>

    

        {isEditing && (
          
          <div className="edit-name">
            
            <input
              type="text"
              value={newName}
              onChange={handleNameChange}
            />
            <button onClick={handleNameSave}>저장</button>
          </div>
        )}
        <div className="user-info">
          <h2>{userName}</h2>
        </div>
        <div className="achievement-circle">
          
          <span>달성률 {achievementRate}%</span>
        </div>
        <p>point: {points}</p>
        </div>
      
  
     <h3>현재 활동중인 챌린지 </h3>
      <div className="challenges">
        <div className="challenge">
        <span role="img" aria-label="challenge1">🌿</span>
        <span>{ 챌린지[0] }</span>
          <span style={{color:'green'}}>{ 얻을포인트[0] }</span>
        </div>
        <div className="challenge">
        <span role="img" aria-label="challenge2">🌿</span>
          <span>{ 챌린지[1] }</span>
          <span style={{color:'green'}}>{ 얻을포인트[1] }</span>
        </div>
        <div className="challenge">
        <span role="img" aria-label="challenge3">🌿</span>
          <span>{ 챌린지[2] }</span>
          <span style={{color:'green'}}>{ 얻을포인트[2] }</span>
        </div>
      </div>

      {attendancePopup && (
        <div className="popup">
          <p>출석을 완료하여 2점을 얻었습니다!
          
          </p>
          <button onClick={handleAttendanceComplete}>완료</button>
        </div>
      )}

      {questPopup && (
        <div className="popup">
          <p>{currentQuest}</p>
          <button onClick={handleQuestComplete}>체크</button>
        </div>
      )}
    </div>
  );
}

export default App;
