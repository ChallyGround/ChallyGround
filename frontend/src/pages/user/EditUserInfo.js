// EditUserInfo.js
import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';
import api from '../../api/axiosApi';

function EditUserInfo({ closeEditUserInfo }) {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [telephone, setTelephone] = useState('');

    const saveUserInfo = () => {
        // 사용자 정보 저장 로직 추가
        alert(`Name: ${name}, Email: ${email}, Telephone: ${telephone}`);
        closeEditUserInfo();
    };

    const [variable, setVariable] = useState([]);
    useEffect(() => {
        api.post("/viewMyInfo")
            .then(response => {
                setVariable([response.data.name, response.data.email, response.data.tel]);
            })
    }, []);

    const handleSaveUserInfo = () => {
        // 예제 저장 로직
        console.log('저장:', { name, email, telephone });
    
        Swal.fire({
          title: '저장 완료!',
          text: '회원정보가 성공적으로 저장되었습니다.',
          icon: 'success',
          confirmButtonText: '확인'
        });
      };

    return (
        <div className="container">
            <h2>회원정보 수정</h2>
            <form id="updateForm">
                <div className="form-group">
                    <label htmlFor="name">이름</label>
                    <input type="text" id="name" name="name" value={variable[0]} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="email">이메일</label>
                    <input type="email" id="email" name="email" value={variable[1]} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="telephone">전화번호</label>
                    <input type="tel" id="telephone" name="telephone" value={variable[2]} onChange={(e) => setTelephone(e.target.value)} required />
                </div>
                <div className="form-group">
                    <button type="button" onClick={handleSaveUserInfo}>저장</button>
                </div>
            </form>
        </div>
    );
}

export default EditUserInfo;