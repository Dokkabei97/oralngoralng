import React from 'react';
import {Box, Button, Divider, Drawer, List, ListItem, Typography} from "@mui/material";
import styles from './_sidebar.module.scss';

const Sidebar = () => {
    return (
        <Box className={styles.box}>
            <Box className={styles.header}>
                <Typography
                    className={styles.oralng}
                >
                    ORALNG ORALNG
                </Typography>
            </Box>
            <Divider/>
            <List className={styles.list}>
                <ListItem className={styles.listItem}>
                    <Button
                        variant="text"
                        className={styles.textBtn}
                    >
                        1
                    </Button>
                </ListItem>
                <ListItem className={styles.listItem}>
                    <Button
                        variant="text"
                        className={styles.textBtn}
                    >
                        <Typography>2</Typography>
                    </Button>
                </ListItem>
            </List>
            <Divider/>
            <List className={styles.list}>
                <ListItem className={styles.listItem}>
                    <Button
                        className={styles.textBtn}
                        variant="text"
                    >
                        3
                    </Button>
                </ListItem>
                <ListItem className={styles.listItem}>
                    <Button
                        variant="text"
                        className={styles.textBtn}
                    >
                        4
                    </Button>
                </ListItem>
            </List>
            <Divider/>
            <Box className={styles.footer}>
                <Typography
                    className={styles.oralng}
                >
                    ORALNG ORALNG
                </Typography>
            </Box>
        </Box>
    );
};

export default Sidebar;