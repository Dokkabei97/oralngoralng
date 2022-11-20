export default function AuthPage() {
    return (
        <div className={"flex justify-center"}>
            <div className={"rounded-md border-2 border-black w-1/4 h-1/4"}>
                <div>
                    <div className={"flex justify-center"}>
                        <label>
                            Email
                            <input
                                type="text"
                                className={"rounded-md border-2 w-1/2 h-1/2 m-5"}
                            />
                        </label>
                    </div>
                    <div className={"flex justify-center"}>
                        <label>
                            Password
                            <input
                                type="password"
                                className={"rounded-md border-2 w-1/2 h-1/2 m-5"}
                            />
                        </label>
                    </div>
                    <div className={"flex justify-center"}>
                        <button
                            className={"rounded-md border-2 bg-oralng w-1/2 h-1/2 m-5"}
                        >
                            로그인
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}