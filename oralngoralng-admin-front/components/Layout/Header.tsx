import React from "react";
import Head from "next/head";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {AccountCircle} from "@mui/icons-material";
import {Grid, Menu, MenuItem} from "@mui/material";
import styles from './_header.module.scss';

const Header = () => {
    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

    const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <Head>
            <title>
                ORALNG ORALNG
            </title>
            <AppBar position="static" className={styles.appbar}>
                <Toolbar>
                    <Grid container spacing={2}>
                        <Grid item xs={3}></Grid>
                        <Grid item xs={3}>
                            <IconButton
                                className={styles.menu}
                                size="large"
                                edge="start"
                                aria-label="menu"
                            >
                                <MenuIcon/>
                            </IconButton>
                            <Typography
                                className={styles.oralng}
                            >
                                ORALNG ORALNG
                            </Typography>
                        </Grid>
                        <Grid item xs={3}>
                            <IconButton
                                className={styles.account}
                                size="large"
                                aria-label="account of current user"
                                aria-controls="menu-appbar"
                                aria-haspopup="true"
                                onClick={handleMenu}
                            >
                                <AccountCircle/>
                            </IconButton>
                            <Menu
                                id="menu-appbar"
                                anchorEl={anchorEl}
                                anchorOrigin={{
                                    vertical: 'top',
                                    horizontal: 'right',
                                }}
                                keepMounted
                                transformOrigin={{
                                    vertical: 'top',
                                    horizontal: 'right',
                                }}
                                open={Boolean(anchorEl)}
                                onClose={handleClose}
                            >
                                <MenuItem onClick={handleClose}>Profile</MenuItem>
                                <MenuItem onClick={handleClose}>My account</MenuItem>
                            </Menu>
                        </Grid>
                        <Grid item xs={3}>
                        </Grid>
                    </Grid>
                </Toolbar>
            </AppBar>
        </Head>
    );
};

export default Header;

