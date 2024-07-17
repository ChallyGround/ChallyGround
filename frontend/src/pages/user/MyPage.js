import React from 'react';
import { Box, Grid, Paper, Typography } from '@mui/material';
import { DataGrid } from '@mui/x-data-grid';

const participationChallenges = [
  { id: 1, name: '하루 한 번 3km 씩 걷기', progress: '24%' },
  { id: 2, name: '플랭크 1분 유지', progress: '75%' },
];

const completedChallenges = [
  { id: 1, name: '멋쟁이사자처럼!', date: '2022년 2월 14일' },
  { id: 2, name: '다함께 도우며', date: '2022년 1월 30일' },
  { id: 3, name: '뒷산 마스터', date: '2021년 10월 22일' },
  { id: 4, name: '다함께 트래킹', date: '2021년 3월 3일' },
];

const upcomingChallenges = [
  { id: 1, name: '하루에 2리터 물 마시기', startDate: '2025년 5월 5일' },
];

const columns = [
  { field: 'id', headerName: 'ID', width: 90 },
  { field: 'name', headerName: 'Name', width: 150, editable: true },
  { field: 'progress', headerName: 'Progress', width: 150, editable: true },
];

function MyPage() { // 컴포넌트명은 대문자로 시작
  return (
    <Box sx={{ flexGrow: 1, p: 2 }}>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Typography variant="h5">참여중인 챌린지</Typography>
          <Paper sx={{ height: 200, width: '100%', mt: 2 }}>
            <DataGrid
              rows={participationChallenges}
              columns={columns}
              pageSize={5}
              rowsPerPageOptions={[5]}
              checkboxSelection
              disableSelectionOnClick
            />
          </Paper>
        </Grid>
        <Grid item xs={12}>
          <Typography variant="h5">참여완료 챌린지</Typography>
          <Grid container spacing={2} sx={{ mt: 2 }}>
            {completedChallenges.map((challenge) => (
              <Grid item xs={6} sm={3} key={challenge.id}>
                <Paper sx={{ p: 2 }}>
                  <Typography variant="h6">{challenge.name}</Typography>
                  <Typography variant="body2">{challenge.date}</Typography>
                </Paper>
              </Grid>
            ))}
          </Grid>
        </Grid>
        <Grid item xs={12}>
          <Typography variant="h5">참여예정 챌린지</Typography>
          <Paper sx={{ p: 2, mt: 2 }}>
            <Grid container spacing={2}>
              {upcomingChallenges.map((challenge) => (
                <Grid item xs={12} key={challenge.id}>
                  <Typography variant="h6">{challenge.name}</Typography>
                  <Typography variant="body2">{challenge.startDate}</Typography>
                </Grid>
              ))}
            </Grid>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
}

export default MyPage;