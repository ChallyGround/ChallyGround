// EditUserInfo.js
import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';
import api from '../../api/axiosApi';
import Button from '@mui/material/Button';

function EditUserInfo({ closeEditUserInfo }) {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [tel, setTelephone] = useState('');
    const [variable, setVariable] = useState([]);

    const saveUserInfo = async function() {
        if(tel.split('-').length != 3) {
            Swal.fire({
                title: '경고!',
                text: '전화번호 양식은 000-0000-0000입니다.',
                icon: 'warning',
                confirmButtonText: '확인'
              });
              return;
        }

        const result = await api.post('/modifyMyInfo', { name, email, tel });
        console.log("fasd", result);

            
        Swal.fire({
            title: '저장 완료!',
            text: '회원정보가 성공적으로 저장되었습니다.',
            icon: 'success',
            confirmButtonText: '확인'
          });
    };

    
    useEffect(() => {
        api.post("/viewMyInfo")
            .then(response => {
                setName(response.data.name);
                setEmail(response.data.email);
                setTelephone(response.data.tel);
            })
    }, []);

    const handleSaveUserInfo = () => {
        saveUserInfo();
        console.log('저장:', { name, email, tel });

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
                    <input type="text" id="email" name="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="telephone">전화번호</label>
                    <input type="email" id="tel" name="tel" value={tel} onChange={(e) => setTelephone(e.target.value)} required />
                </div>
                <div className="form-group">
                    <Button type="button" variant="contained" onClick={handleSaveUserInfo}>저장</Button>
                </div>
            </form>
        </div>
    );
}

export default EditUserInfo;