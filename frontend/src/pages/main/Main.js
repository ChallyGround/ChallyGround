import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';

const hostUrl = process.env.REACT_APP_API_URL;

const Main = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    axios.get(hostUrl + '/home', { withCredentials: true })
      .then(response => setUser(response.data))
      .catch(error => console.error('Error fetching user:', error));
  }, []);

  return (
    <div>
      <h1>Home</h1>
      {user ? <p>Welcome, {user}</p> : <p>Loading...</p>}
    </div>
  );
};

export default Main;