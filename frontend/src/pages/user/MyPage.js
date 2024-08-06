import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import '../../css/mypage.css';
import Button from '@mui/material/Button';
import api from '../../api/axiosApi';

function MyPage() {
    const hostUrl = process.env.REACT_APP_API_URL;

    const navigate = useNavigate();
    const [profileImage, setProfileImage] = useState(null);
    const [name, setName] = useState(null);

    useEffect(() => {
        api.get("/viewMyInfo")
            .then(response => {
                const imagePath = response.data.profileImage;
                const encodedImagePath = encodeURIComponent(imagePath); // URL 인코딩
                const imageUrl = hostUrl + `/chally/uploads/${encodedImagePath}`;
                setProfileImage(imageUrl);
                
                setName(response.data.name);
            });
    }, []);

    const editUserInfo = () => {
        navigate('/chally/editUserInfo');
    };

    return (
        <div className="main">
            <div>
                <div className="user_box">
                    <p className="user_name">{name}</p>
                    <div className="user_picture">
                        {profileImage && <img src={profileImage} alt="Profile" style={{ width: '100%', height: '100%', borderRadius: '120px' }} />}
                    </div>
                    <div className="form">
                        <Button type="button" variant="contained" onClick={editUserInfo}>수정하기</Button>
                    </div>
                </div>
                <div className="challenge-box">
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
        </div>
    );
}

export default MyPage;
