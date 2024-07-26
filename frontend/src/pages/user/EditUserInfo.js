// EditUserInfo.js
import React, { useState } from 'react';

function EditUserInfo({ closeEditUserInfo }) {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [telephone, setTelephone] = useState('');

    const saveUserInfo = () => {
        // 사용자 정보 저장 로직 추가
        alert(`Name: ${name}, Email: ${email}, Telephone: ${telephone}`);
        closeEditUserInfo();
    };

    return (
        <div className="container">
            <h2>회원정보 수정</h2>
            <form id="updateForm">
                <div className="form-group">
                    <label htmlFor="name">이름</label>
                    <input type="text" id="name" name="name" value={name} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="email">이메일</label>
                    <input type="email" id="email" name="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="telephone">전화번호</label>
                    <input type="tel" id="telephone" name="telephone" value={telephone} onChange={(e) => setTelephone(e.target.value)} required />
                </div>
                <div className="form-group">
                    <button type="button" onClick={saveUserInfo}>저장</button>
                </div>
            </form>
        </div>
    );
}

export default EditUserInfo;