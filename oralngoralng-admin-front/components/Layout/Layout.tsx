import Header from "./Header";
import Footer from "./Footer";
import SearchBar from "./SearchBar";
import Sidebar from "./Sidebar";
import {useEffect, useState} from "react";

const Layout = ({ children }: { children: any }) => {
    const [handleDrawerToggle, setHandleDrawerToggle] = useState(true);

    const clickHandleDrawerToggle = () => {
        setHandleDrawerToggle(!handleDrawerToggle);
        console.log(handleDrawerToggle)
    }

    return (
        <>
            <Sidebar
                open={handleDrawerToggle}
                onClose={clickHandleDrawerToggle}
            />
            <Header onDrawerToggle={clickHandleDrawerToggle}/>
            <main>
                {/*<SearchBar/>*/}
                {children}
            </main>
            <Footer/>
        </>
    );
};

export default Layout;