import Link from "../../node_modules/next/link";
import MainLayout from "./components/MainLayoutComponent";

export default function Home() {
  return (

    <>
    <MainLayout/>

    <div className="container">
          <div className="row mx-auto text-center mt-3">
            <div className="col">
                <Link href="/crearpregunta">

              <button className='btn btn-primary'>Crear Preguntas</button>
                </Link>
            </div>
            <div className="col">
                <Link href="/prueba">

                    <button className='btn btn-primary'>Iniciar Prueba</button>
                </Link>
            </div>

          </div>

      </div>
    </>

  )
}
