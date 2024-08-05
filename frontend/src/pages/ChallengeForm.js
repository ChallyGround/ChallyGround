import React, { useState } from 'react';
import './ChallengeForm.css';
import EditorBox from './EditorBox'; 

const ChallengeForm = () => {
    const [title, setTitle] = useState('');
    const [participants, setParticipants] = useState(2);
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');

    const handleDecrease = () => {
        if (participants > 1) {
            setParticipants(participants - 1);
        }
    };

    const handleIncrease = () => {
        setParticipants(participants + 1);
    };

    const handlePreview = () => {
        alert('미리보기 기능은 아직 구현되지 않았습니다.');
    };

    const handleSave = () => {
        alert('임시저장 기능은 아직 구현되지 않았습니다.');
    };

    const handleSubmit = () => {
        if (title && startDate && endDate) {
            if (new Date(startDate) > new Date(endDate)) {
                alert('시작일이 종료일보다 늦을 수 없습니다.');
                return;
            }
            alert('챌린지가 성공적으로 등록되었습니다!');
        } else {
            alert('모든 필드를 채워주세요.');
        }
    };

    return (
        <div className="challenge-form">
            <h2>챌린지 등록</h2>
            <div className="form-group">
                <label htmlFor="title">챌린지 제목</label>
                <input 
                    type="text" 
                    id="title" 
                    placeholder="예) 걷기 (X) → 하루 한 번 3km 씩 걷기 (O)" 
                    value={title} 
                    onChange={(e) => setTitle(e.target.value)} 
                />
            </div>
            <div className="form-group">
                <label htmlFor="content">챌린지 내용</label>
                <EditorBox /> {}
            </div>
            <div className="form-group">
                <label>참여 인원</label>
                <div className="participants-input">
                    <button type="button" onClick={handleDecrease}>-</button>
                    <span>{participants}</span>
                    <button type="button" onClick={handleIncrease}>+</button>
                </div>
            </div>
            <div className="form-group">
                <label>기간</label>
                <div className="date-input">
                    <input 
                        type="date" 
                        value={startDate} 
                        onChange={(e) => setStartDate(e.target.value)} 
                    />
                    <input 
                        type="date" 
                        value={endDate} 
                        onChange={(e) => setEndDate(e.target.value)} 
                    />
                </div>
            </div>
            <div className="form-actions">
                <button type="button" onClick={handlePreview}>미리보기</button>
                <button type="button" onClick={handleSave}>임시저장</button>
                <button type="button" onClick={handleSubmit}>등록하기</button>
            </div>
        </div>
    );
};

export default ChallengeForm;
