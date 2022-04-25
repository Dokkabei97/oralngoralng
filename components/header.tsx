import React from "react";
import Head from "next/head";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import {AccountCircle} from "@mui/icons-material";
import {Grid, Menu, MenuItem} from "@mui/material";

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
            <Box sx={{flexGrow: 1}}>
                <AppBar
                    position="static"
                    sx={{backgroundColor: 'white'}}
                >
                    <Toolbar>

                        <Grid container spacing={{ xs:2, md:3 }}>
                            <Grid item xs={8}>
                                <IconButton
                                    size="large"
                                    edge="start"
                                    aria-label="menu"
                                    sx={{mr: 2}}
                                >
                                    <MenuIcon/>
                                </IconButton>
                            </Grid>
                        </Grid>
                        <Grid container spacing={{ xs:2, md:3 }}>
                            <Grid item xs={8}>
                                <Typography
                                    variant="h6"
                                    component="div"
                                    color={'rgba(0, 117, 255, 0.72)'}
                                    sx={{
                                        flexGrow: 1,
                                        fontWeight: "bold"
                                    }}
                                >
                                    ORALNG ORALNG
                                </Typography>
                            </Grid>
                        </Grid>

                        <Grid container spacing={{ xs:2, md:3 }}>
                            <Grid item xs={8}>
                                <IconButton
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
            </Box>
        </Head>
    );
};

export default Header;

