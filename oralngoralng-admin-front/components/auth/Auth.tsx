import {Grid} from '@mui/material';
import React from 'react';

import styles from './_auth.module.scss';

const Auth = ({ children }: { children: any }) => {
    return (
        <Grid container spacing={2} className={styles.global}>
            <Grid item xs={4}>
            </Grid>
            <Grid item xs={4} className={styles.authForm}>
                {children}
            </Grid>
            <Grid item xs={4}>
            </Grid>
        </Grid>
    );
};

export default Auth;