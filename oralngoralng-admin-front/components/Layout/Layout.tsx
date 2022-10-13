import Header from "./Header";
import Footer from "./Footer";
import Sidebar from "./Sidebar";

import styles from './_layout.module.scss';
import {Paper} from "@mui/material";

const Layout = ({ children }: { children: any }) => {

    return (
        <>
            <Header/>
            <div className={styles.div}>
                <Sidebar/>
                <div className={styles.main}>
                    {children}
                </div>
            </div>
            <Footer/>
        </>
    );
};

export default Layout;