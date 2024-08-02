import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';

const drawerWidth = 240;
const Main = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    axios.get('http://49.174.231.190:8080/home', { withCredentials: true })
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