export default function AuthPage() {
    return (
        <section className={"text-gray-600 body-font"}>
            <div className={"container px-5 py-24 mx-auto flex flex-wrap items-center"}>
                <div className={"lg:w-3/5 md:w-1/2 md:pr-16 lg:pr-0 pr-0"}>
                    <h1 className={"title-font font-medium text-3xl text-gray-900"}>
                        OralngOralng Admin Service
                    </h1>
                    <p className={"leading-relaxed mt-4"}>
                        올랑올랑 어드민 서비스 입니다,
                        계정 및 사용 관련 문의는 담당자를 통해 요청 부탁드립니다.
                    </p>
                </div>
                <div
                    className={"lg:w-2/6 md:w-1/2 bg-gray-100 rounded-lg p-8 flex flex-col md:ml-auto w-full mt-10 md:mt-0"}>
                    <h2 className={"text-gray-900 text-lg font-medium title-font mb-5"}>
                        어드민 로그인
                    </h2>
                    <div className={"relative mb-4"}>
                        <label htmlFor={"employeeNumber"} className={"leading-7 text-sm text-gray-600"}>
                            사원번호
                        </label>
                        <input type={"text"}
                               id={"employeeNumber"}
                               name={"employeeNumber"}
                               className={"w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"}/>
                    </div>
                    <div className={"relative mb-4"}>
                        <label htmlFor={"password"} className={"leading-7 text-sm text-gray-600"}>
                            비밀번호
                        </label>
                        <input type={"password"} id={"password"} name={"password"}
                               className={"w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"}/>
                    </div>
                    <button
                        className={"text-white bg-blue-500 border-0 py-2 px-8 focus:outline-none hover:bg-blue-600 rounded text-lg"}>
                        로그인
                    </button>
                    <p className={"text-xs text-gray-500 mt-3"}>
                        비밀번호는 분실 시 담당자가 새롭게 발급해 드립니다.
                    </p>
                </div>
            </div>
        </section>
    );
}