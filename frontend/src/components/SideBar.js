import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';
import Toolbar from '@mui/material/Toolbar';
import { Home, Description, CardGiftcard, RateReview, FitnessCenter, Settings, SubdirectoryArrowRight } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import { getValue } from '@mui/system';

export default function SideBar() {
  const [openItems, setOpenItems] = useState({});

  const toggleItem = (index) => {
    setOpenItems((prevState) => ({
      ...prevState,
      [index]: !prevState[index],
    }));
  };

  const menuItems = [
    { text: '홈', icon: <Home />, subItems: [{ text: '홈 세부 항목 1', link: '/home/sub1' }, { text: '홈 세부 항목 2', link: '/home/sub2' }] },
    { text: '소식', icon: <Description />, subItems: [{ text: '소식 세부 항목 1', link: '/news/sub1' }, { text: '소식 세부 항목 2', link: '/news/sub2' }] },
    { text: '쿠폰', icon: <CardGiftcard />, subItems: [{ text: '쿠폰 세부 항목 1', link: '/coupons/sub1' }, { text: '쿠폰 세부 항목 2', link: '/coupons/sub2' }] },
    { text: '후기', icon: <RateReview />, subItems: [{ text: '후기 세부 항목 1', link: '/reviews/sub1' }, { text: '후기 세부 항목 2', link: '/reviews/sub2' }] },
    { text: '챌린지', icon: <FitnessCenter />, subItems: [{ text: '챌린지 세부 항목 1', link: '/challenges/sub1' }, { text: '챌린지 세부 항목 2', link: '/challenges/sub2' }] },
    { text: '설정', icon: <Settings />, subItems: [{ text: '설정 세부 항목 1', link: '/settings/sub1' }, { text: '설정 세부 항목 2', link: '/settings/sub2' }] },
  ];

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Drawer
        sx={{
          width: 239,
          height: 64,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: 239,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Toolbar />
        <Divider />
        <List>
          {menuItems.map((item, index) => (
            <React.Fragment key={item.text}>
              <ListItem disablePadding>
                <ListItemButton onClick={() => toggleItem(index)}>
                  <ListItemIcon>{item.icon}</ListItemIcon>
                  <ListItemText primary={item.text} />
                </ListItemButton>
              </ListItem>
              {openItems[index] && (
                <List component="div" disablePadding>
                  {item.subItems.map((subItem) => (
                    <ListItem key={subItem.text} disablePadding>
                      <ListItemButton component={Link} to={subItem.link} sx={{ pl: 4 }}>
                        <SubdirectoryArrowRight/>
                        <ListItemText primary={subItem.text} />
                      </ListItemButton>
                    </ListItem>
                  ))}
                </List>
              )}
            </React.Fragment>
          ))}
        </List>
      </Drawer>
    </Box>
  );
}
