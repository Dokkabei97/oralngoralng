import React, {useState} from "react";
import Head from "next/head";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {AccountCircle, Power} from "@mui/icons-material";
import {Grid, Hidden, Menu, MenuItem} from "@mui/material";
import styles from './_header.module.scss';


const Header = ({onDrawerToggle}) => {

    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

    const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <AppBar position="static" elevation={0} className={styles.appbar}>
            <Toolbar>
                <Grid container alignItems={"center"}>
                    <Grid item xs={2}>
                    </Grid>
                    <Grid item xs={6}>
                        <IconButton
                            aria-label="Open drawer"
                            onClick={onDrawerToggle}
                        >
                            <MenuIcon
                                className={styles.icon}
                            />
                        </IconButton>
                    </Grid>
                    <Grid item xs={4}>
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
                </Grid>
            </Toolbar>
        </AppBar>
    );
};

export default Header;

