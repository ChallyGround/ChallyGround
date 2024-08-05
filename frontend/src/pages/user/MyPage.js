import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import '../../css/mypage.css';
import Button from '@mui/material/Button';
import api from '../../api/axiosApi';

function MyPage() {
    const navigate = useNavigate();
    const [profileImage, setProfileImage] = useState(null);

    useEffect(() => {
        api.post("/viewMyInfo")
            .then(response => {
                setProfileImage(response.data.profileImageUrl);
            });
    }, []);

    const editUserInfo = () => {
        navigate('/chally/editUserInfo');
    };

    return (
        <div className="main">
            <div>
                <div className="user_box">
                    <p className="user_name">chally</p>
                    <div className="user_picture">
                        {profileImage && <img src={profileImage} alt="Profile" style={{ width: '100px', height: '100px' }} />}
                    </div>
                    <div className="form">
                        <Button type="button" variant="contained" onClick={editUserInfo}>수정하기</Button>
                    </div>
                </div>

                <div className="ing">참여중인 챌린지
                    <div className="ing-1"></div>
                    <div className="ing-2"></div>
                </div>
                <div className="finish">참여 완료 챌린지
                    <div className="finish-1"></div>
                    <div className="finish-2"></div>
                    <div className="finish-3"></div>
                </div>
                <div className="soon">참여 예정 챌린지
                    <div className="soon-1"></div>
                    <div className="soon-2"></div>
                </div>
            </div>
        </div>
    );
}

export default MyPage;
