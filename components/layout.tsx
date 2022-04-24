import type {NextPage} from 'next'
import Header from "./header";

const Layout = ({children}) => {
    return (
        <>
            <Header/>
            {children}
        </>
    );
};

export default Layout;