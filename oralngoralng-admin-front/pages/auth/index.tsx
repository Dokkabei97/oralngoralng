import React from 'react';
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Auth from "../components/auth/Auth";
import {Button, Grid, TextField} from '@mui/material';
import styles from 'pages/auth/_auth_page.module.scss';

const Index = () => {
    return (
        <Auth>
            <Box className={styles.box} xs={12}>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <Typography className={styles.typography}>ORALNG ORALNG</Typography>
                        <TextField
                            id="standard-search"
                            label="Email"
                            variant="standard"
                            fullWidth
                            className={styles.searchField}
                        />
                        <TextField
                            id="standard-password-input"
                            label="Password"
                            type="password"
                            autoComplete="current-password"
                            variant="standard"
                            fullWidth
                            className={styles.passwordField}
                        />
                        <Button
                            variant="contained"
                            fullWidth
                            className={styles.loginButton}
                        >
                            로그인
                        </Button>
                    </Grid>
                </Grid>
            </Box>
        </Auth>
    );
};

export default Index;