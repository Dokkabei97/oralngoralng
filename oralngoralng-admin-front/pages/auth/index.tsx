import React from 'react';
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Auth from "../../components/auth/Auth";
import {Button, Grid, TextField} from '@mui/material';


const Index = () => {
    return (
        <Auth>
            <Box
                sx={{
                    width: 500,
                    height: 500,
                    backgroundColor: 'primary.dark'
                }}
            >
                <Grid container spacing={2}>
                    <Grid item xs={4}>
                    </Grid>
                    <Grid item xs={4}>
                        <Typography>Sign In</Typography>
                        <TextField
                            id="standard-search"
                            label="Search field"
                            type="search"
                            variant="standard"
                        />
                        <TextField
                            id="standard-password-input"
                            label="Password"
                            type="password"
                            autoComplete="current-password"
                            variant="standard"
                        />
                        <Button variant="contained">로그인</Button>
                    </Grid>
                    <Grid item xs={4}>
                    </Grid>
                </Grid>
            </Box>
        </Auth>
    );
};

export default Index;